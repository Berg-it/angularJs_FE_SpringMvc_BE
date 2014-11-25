'use.strict';


	/********Authentification Controller******/
	/*****************************************/
	app.controller('authCtrl',function(UserAuthFacotry,$scope,$window,$location,$rootScope,$cookies,$cookieStore,$ngSessionStorage){

			$scope.doLogin = function() {
                if($scope.pass == undefined )
                {
                    toastr.error('Correct your Password!');
                }
				//Get list of comment from file externe like webservice
                else
                {
                    $scope.result = UserAuthFacotry.authUserFunction($scope,$rootScope).then(
                        function(data){
                            if(data.responseMessage.indexOf('error') != -1){
                                toastr.error('No user regitred with this identifier!');
                            }
                            else{
                                $cookieStore.put('mailUser',data.user.email);
                                $scope.result = data;
                                $cookies.user_access = 'true';

                                $ngSessionStorage.addItem("mail",data.user.email);
                                $ngSessionStorage.addItem("pass",data.user.pass);
                                $ngSessionStorage.addItem("name",data.user.name);
                                $ngSessionStorage.addItem("lastname",data.user.lastname);
                                $window.location.href = "home.html";
                            }
                        },
                        function(msg){
                            toastr.error(msg);
                        }
                    )

                }



			}   
			}); 
 