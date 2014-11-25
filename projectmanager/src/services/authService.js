'use.strict';
/**
 * Created by amine.berguiga on 10/11/2014.
 */

/*<!--Declare Factory Service -->*/
app.factory('UserAuthFacotry',function($http,$q){
    var factory ={
        backData : false,
        authUserFunction:function($scope){
            var deferred = $q.defer();
            $http({
                method: "get",
                url: "http://localhost:8080/firstSpringApplication/users/authUser",
                params: {
                    mail:$scope.mail,
                    pass:$scope.pass
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