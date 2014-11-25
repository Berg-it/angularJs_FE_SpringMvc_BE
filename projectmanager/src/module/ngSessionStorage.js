/**
 * Created by amine.berguiga on 24/11/2014.
 */
'use strict';
(function()
{
    angular.module('ngSessionStorage', []).factory('$ngSessionStorage',function($rootScope) {
        var factory ={
            addItem:function(key,value){
                sessionStorage.setItem(key, value);
            },
            getItem:function(key){
                return sessionStorage.getItem(key);
            },
            getAllItem:function(){
                for (var key in sessionStorage) {
                    console.log("from arrayStorage key is: "+key+" get Item "+sessionStorage.getItem(key));
                }
            },
            deleteItem:function(key){
                sessionStorage.removeItem(key);
            },
            deleteAllItem:function() {
                for (var oneItem in sessionStorage) {
                    sessionStorage.removeItem(oneItem);
                }
            }
        }
        return factory;
    });
})();

