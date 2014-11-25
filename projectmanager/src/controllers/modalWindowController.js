/**
 * Created by amine.berguiga on 19/11/2014.
 */

'use.strict';

modalWindowShow.controller('ModalWindowShow',function ($rootScope,$scope, $modal, $log) {
    $rootScope.items    = [''];
    $rootScope.openModalWindow = function (nameTempalte,operationToDo) {
        $rootScope.nameOperation = operationToDo;
        var myWindowShow = $modal.open({
            templateUrl: nameTempalte,
            controller : 'ModalInstanceCtrl',
            resolve    : {
                items: function () {
                    return $rootScope.items;
                },
                oldValue : function () {
                    switch (operationToDo) {
                        case "Name":
                            return $rootScope.name;
                            break;
                        case "Last Name":
                            return $rootScope.lastname;
                            break;
                        case "Email":
                            return $rootScope.mail;
                            break;
                        case "Password":
                            return $rootScope.pass;
                            break;
                    }
                }
            }
        });

        myWindowShow.result.then(function (selectedItem) {
            if(selectedItem!="")
            {
                switch (operationToDo) {
                    case "Name":
                        $rootScope.name = selectedItem;
                        break;
                    case "Last Name":
                        $rootScope.lastname = selectedItem;
                        break;
                    case "Email":
                        $rootScope.mail = selectedItem;
                        break;
                    case "Password":
                        $rootScope.pass = selectedItem;
                        break;
                }
            }
            $log.info('Modal dismissed at: ' + new Date()+" with selected item  "+selectedItem);
        }, function () {
            $log.info('Modal dismissed at: ' + new Date());
        });
    };
});

// Please note that $modalInstance represents a modal window (instance) dependency.
// It is not the same as the $modal service used above.

modalWindowShow.controller('ModalInstanceCtrl', function ($rootScope,$scope, $modalInstance, items,oldValue) {

    $rootScope.oldValue=oldValue;
    console.log("$rootScope.oldValue "+$rootScope.oldValue);
    $rootScope.items = items;
    $rootScope.selected = {
        item: ""
    };

    $rootScope.newValueTmp = "";

    $rootScope.ok = function () {
        $modalInstance.close($rootScope.selected.item);
    };

    $rootScope.cancel = function () {
        $modalInstance.dismiss('cancel');
    };
});