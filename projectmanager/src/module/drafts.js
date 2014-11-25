/**
 * Created by amine.berguiga on 24/11/2014.
 */
'use strict';
(function()
{
    angular.module('ngSessionStorage', []).factory('$ngSessionStorage',function($rootScope) {
        var factory ={
            storageArray:{
            },
            init:function(){
                if(sessionStorage.getItem("change") == "true")
                {
                    sessionStorage.setItem("change","false");
                    for (var key in sessionStorage) {
                        console.log("from Sessionstorage key is: "+key+" get Item "+sessionStorage[key]);
                        if(key!= "change"){
                            this.storageArray[key]= sessionStorage[key];
                            // sessionStorage.removeItem(key);
                        }
                    }
                }
            },
            addItem:function(key,value){
                this.storageArray[key]=value;
            },
            getItem:function(key){
                return this.storageArray[key];
            },
            getAllItem:function(){
                console.log("Length "+isEmptyObject(this.storageArray));
                for (var key in this.storageArray) {
                    console.log("from arrayStorage key is: "+key+" get Item "+this.storageArray[key]);
                }
            },
            deleteItem:function(key){
                this.storageArray[key]=undefined;
            },
            deleteAllItem:function(){
                for (var oneItem in this.storageArray) {
                    oneItem=undefined;
                }
            },
            addItemAnotherCtrl:function(key,value){
                sessionStorage.setItem("change","true");
                sessionStorage.setItem(key,value);
                console.log("Another Ctrl");
            }
        }
        return factory;
    });
})();

