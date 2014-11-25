 // I add a friend with the given name to the remote collection.
                function addFriend( name ) {
 
                    var request = $http({
                        method: "post",
                        url: "api/index.cfm",
                        params: {
                            action: "add"
                        },
                        data: {
                            name: name
                        }
                    });
 
                    return( request.then( handleSuccess, handleError ) );
 
                }

services.factory('Auth', function($http){
  return {
        load: function() {
            return $http.get('/api/v1/auth');
        },
        logout: function() {
            return $http.get('/api/v1/auth/logout');
        },
        login: function(inputs) {
            return $http.post('/api/v1/auth/login', inputs);
        },
        register: function(inputs) {
            return $http.post('/api/v1/auth/register', inputs);
        },
        locations: function() {
            return $http.get('/api/v1/auth/locations');
        },
        check: function() {
            return $http.get('/api/v1/auth/check');
        }
    }
});

    $scope.loginUser = function() {
        Auth.login({
            username: $scope.main.credentials.email,
            password: $scope.main.credentials.password
        })
        .success(function(data) 
        {
            if (data.error) 
            {
                toastr.error(data.error);
            }
            else
            {
                toastr.success("You are signed in!");
                $scope.loadAuth();
                $scope.main.credentials = {};
                Popup.close();
            }
        }
        );
    }

    /***********************************/


.controller('LoginController', function ($scope, $rootScope, AUTH_EVENTS, AuthService) {
  $scope.credentials = {
    username: '',
    password: ''
  };
  $scope.login = function (credentials) {
    AuthService.login(credentials).then(function (user) {
      $rootScope.$broadcast(AUTH_EVENTS.loginSuccess);
      $scope.setCurrentUser(user);
    }, function () {
      $rootScope.$broadcast(AUTH_EVENTS.loginFailed);
    });
  };
})




.factory('AuthService', function ($http, Session) {
  var authService = {};
 
  authService.login = function (credentials) {
    return $http
      .post('/login', credentials)
      .then(function (res) {
        Session.create(res.data.id, res.data.user.id,
                       res.data.user.role);
        return res.data.user;
      });
  };
 
  authService.isAuthenticated = function () {
    return !!Session.userId;
  };
 
  authService.isAuthorized = function (authorizedRoles) {
    if (!angular.isArray(authorizedRoles)) {
      authorizedRoles = [authorizedRoles];
    }
    return (authService.isAuthenticated() &&
      authorizedRoles.indexOf(Session.userRole) !== -1);
  };
 
  return authService;
})

/******************/

directives.directive('checkUser', ['$rootScope', '$location', 'userSrv', function ($root, $location, userSrv) {
    return {
        link: function (scope, elem, attrs, ctrl) {
            $root.$on('$routeChangeStart', function(event, currRoute, prevRoute){
                if (!prevRoute.access.isFree && !userSrv.isLogged) {
                    // reload the login route
                }
                /*
                * IMPORTANT:
                * It's not difficult to fool the previous control,
                * so it's really IMPORTANT to repeat the control also in the backend,
                * before sending back from the server reserved information.
                */
            });
        }
    }
}]);