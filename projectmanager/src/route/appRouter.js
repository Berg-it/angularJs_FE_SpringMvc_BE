'use.strict';

angular.module('routeApp', ['ngRoute']).config(function($routeProvider) {

			$routeProvider.when('/', {
            templateUrl: 'login.html',
            controller : 'authCtrl'
        	});

			$routeProvider.when('/homepage', {
            templateUrl: 'home.html',
            controller : 'homeCtrl'
        	});

/*
            $routeProvider.when('/Dashboard', {
            templateUrl: 'home.html',
            controller : 'homeCtrl'
            });

            $routeProvider.when('/wiki', {
            templateUrl: 'wiki.html',
            controller : 'homeCtrl'
            });            
*/
        	$routeProvider.otherwise({ redirectTo: '/' });

  	      });

angular.module('routeHomeApp', ['ngRoute']).config(function($routeProvider) {

            $routeProvider.when('/homepage', {
            templateUrl: 'home.html',
            controller : 'homeCtrl'
            });

            $routeProvider.when('/Dashboard', {
            templateUrl: 'wiki.html',
            controller : 'homeCtrl'
            });

            $routeProvider.when('/wiki', {
            templateUrl: 'wiki.html',
            controller : 'homeCtrl'
            });

            $routeProvider.when('/taskList', {
            templateUrl: 'taskList.html',
            controller : 'homeCtrl'
            });

            $routeProvider.when('/presence', {
                templateUrl: 'presence.html',
                controller : 'homeCtrl'
            });
            $routeProvider.when('/profile', {
                templateUrl: 'profile.html',
                controller : 'homeCtrl'
            });

            
            $routeProvider.otherwise({ redirectTo: '/' });


          });