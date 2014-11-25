/**
 * Created by amine.berguiga on 19/11/2014.
 */

'use.strict';


/*<!--Declare your Module to manage list of modal window -->*/
var modalWindowShow = angular.module('modalWindowShow',['ui.bootstrap']);

/*<!--Declare your Module of LOGIN -->*/
var app     = angular.module('MonApp',['ngRoute','routeApp','ngCookies','ngSessionStorage']);

/*<!--Declare your Module of Home -->*/
var appHome = angular.module('MyHomeApp',['ngRoute','routeHomeApp','ngCookies','ngResource','ui.bootstrap','modalWindowShow','ngSessionStorage']);
