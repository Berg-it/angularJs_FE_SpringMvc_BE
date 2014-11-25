'use.strict';
	/******Home Controller******/

	/***************************/
	appHome.controller('homeCtrl',function( $log,applWsLink,homeFacotry,
                                            $scope,$location,$rootScope,
                                            $cookies,$window,$cookieStore,
                                            $route,$ngSessionStorage){
				/*Verify if the user connected or not?*/
                $log.log("Home Controller");

                $scope.labelLink=homeFacotry.linkName;
				if($cookies.user_access == 'false'){
				    toastr.error('You have to connect before!');
					console.log("$cookies.user_access "+$cookies.user_access);
					$window.location.href = "index.html";
				}
                else
                {
                    if($cookieStore.get("firstTime") ==undefined)
                    {
                        $cookieStore.put("firstTime",'0');
                        $location.path('/wiki');
                        $cookieStore.put("usedLanguage",'en');
                        $rootScope.usedLanguage='en';
                    }
                }
                $scope.changeLanguage=function()
                {
                    if($rootScope.usedLanguage=='en'){
                        $cookieStore.put("usedLanguage",'fr');
                        $rootScope.usedLanguage='fr';
                        $window.location.href = "home.html";
                    }
                    else{
                        $cookieStore.put("usedLanguage",'en');
                        $rootScope.usedLanguage='en';
                        $window.location.href = "home.html";
                    }
                }
				/*Log Out*/
				$scope.doLogOut = function() {
					$cookies.user_access = 'false';
                    $cookieStore.remove('isEnterOk');
                    $cookieStore.remove('loginUser');
                    $cookieStore.remove('mailUser');
                    $cookieStore.remove('user_access');
                    $cookieStore.remove("usedLanguage");
                    $cookieStore.remove("firstTime");
                    $ngSessionStorage.deleteAllItem();
					$window.location.href = "index.html";
				}
				/*Chnage the state of the link*/
                $scope.tab = 'wiki';
                $scope.pageTitle='wiki';
		        $scope.setSelectedLink = function (tabId,pageName) {
                    if(tabId =='profile'){
                        $rootScope.mail=$ngSessionStorage.getItem("mail");
                        $rootScope.pass=$ngSessionStorage.getItem("pass");
                        $rootScope.name=$ngSessionStorage.getItem("name");
                        $rootScope.lastname=$ngSessionStorage.getItem("lastname");
                    }
		        	$scope.tab = tabId;
                    $scope.pageTitle=pageName;
		            console.log("setTab: "+tabId);
                    console.log("Name Page: "+$scope.pageTitle);
		            $location.path('/'+tabId);
		        }
		        $scope.isSelectedLink = function (tabId) {
		            return $scope.tab === tabId;
		        }

                //Is used to verify if the user enter or not, because we have to disable the Button Enter
                $scope.isEnterOk=false;
                $scope.isEnter= function()
                {
                    return $cookieStore.get('isEnterOk');
                }

                var loginUser  =  $cookieStore.get('mailUser');
                //DoEnter function is used to login the user and add the date time inside the DB
                $scope.doEnter= function(){
                    $cookieStore.put('isEnterOk',true);
                    $scope.result = homeFacotry.userEnterFunction($scope,loginUser).then(
                        function(data){
                            $scope.verifUserConnect();
                        },
                        function(msg){
                            toastr.error(msg);
                        }
                    )

                }
                /*Verify if user connected or not */
                $scope.verifUserConnect=function(){
                    homeFacotry.userVerifyEnterFunction($scope,loginUser).then(
                        function(data){
                            $scope.presences = data.result;
                            if(data.messageResponse=="ok")
                                $cookieStore.put('isEnterOk',true);
                            else
                                $cookieStore.put('isEnterOk',false);
                        },
                        function(msg){
                            toastr.error(msg);
                        }
                    )


                }
                /*Exit from company after the work*/
                $scope.doExit=function(){
                    homeFacotry.userExitFunction($scope,loginUser).then(
                        function(data){
                            $cookieStore.put('isEnterOk',false);
                            $scope.verifUserConnect();
                        },
                        function(msg){
                            toastr.error(msg);
                        }
                    )


                }


                $scope.doUpdateProfile = function(){
                    alert("aaaaaaaa");
                }
                $scope.toUpdate= function(){
                return false;
                }

    });
