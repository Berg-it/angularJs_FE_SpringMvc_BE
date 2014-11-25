'use.strict';
/**
 * Created by amine.berguiga on 12/11/2014.
 */

/*Factory used to save list of link of ws*/
appHome.factory('applWsLink', ['$resource',function($resource) {

    var factory ={
                    arrayListLinkWs :
                    {
                        wsEnterUser: "http://localhost:8080/firstSpringApplication/presence/addUserEntry",
                        wsVerifEnterUser: "http://localhost:8080/firstSpringApplication/presence/verifUserEntry",
                        wsExitUser: "http://localhost:8080/firstSpringApplication/presence/UserExit"
                    }

    }
    return factory;
}]);



/*<!--Declare Factory Service -->*/
appHome.factory('homeFacotry',function($resource,$http,$q,applWsLink){

    var factory ={
        /*Call Ws for enter User*/
        userEnterFunction:function($scope,loginUser){
                        var deferred = $q.defer();
                        $http({
                            method: "get",
                            url:applWsLink.arrayListLinkWs.wsEnterUser,
                            params: {
                                userMail:loginUser
                            }
                        })
                            .success(function(data,status){
                                factory.backData = data;
                                deferred.resolve(factory.backData);
                            })
                            .error(function(data,status){
                                deferred.reject('Erreur into url '+data);
                            })
                        return deferred.promise;
                    },
        /*Call Ws to verify if user enter*/
        userVerifyEnterFunction:function($scope,loginUser){
            var deferred = $q.defer();
            $http({
                method: "get",
                url:applWsLink.arrayListLinkWs.wsVerifEnterUser,
                params: {
                    userMail:loginUser
                }
            })
                .success(function(data,status){
                    factory.backData = data;
                    deferred.resolve(factory.backData);
                })
                .error(function(data,status){
                    deferred.reject('Erreur into url '+data);
                })
            return deferred.promise;
        },
        userExitFunction:function($scope,loginUser){
            console.log("Pres Data  "+$scope.presences[0].entrydate);
            var deferred = $q.defer();
            $http({
                method: "get",
                url:applWsLink.arrayListLinkWs.wsExitUser,
                params: {
                    userMail:loginUser,
                    entryTime:$scope.presences[$scope.presences.length - 1].entrytime,
                    entryDate:$scope.presences[$scope.presences.length - 1].entrydate
                }
            })
                .success(function(data,status){
                    factory.backData = data;
                    deferred.resolve(factory.backData);
                })
                .error(function(data,status){
                    deferred.reject('Erreur into url '+data);
                })
            return deferred.promise;
        }



    }
    return factory;
})

// I load the remote data.
function loadRemoteData($scope,resource) {
    $scope.isLoading = true;
    resource.getFriends().$promise.then(
        function( friends ) {
            console.log("Freind "+friends);
            $scope.isLoading = false;
            $scope.friends   = friends;
        },
        function( error ) {
            // If something goes wrong with a JSONP request in AngularJS,
            // the status code is always reported as a "0". As such, it's
            // a bit of black-box, programmatically speaking.
            alert( "Something went wrong!"+JSON.stringify(error) );

        }
    );
}
