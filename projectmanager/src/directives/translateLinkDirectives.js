/**
 * Created by amine.berguiga on 20/11/2014.
 */

'user strict';

appHome.directive('ngTranslateLink', function($rootScope,$cookieStore,$location) {

    var englishLinkName = {
        verticalLink1  :   'Wiki',
        verticalLink2  :   'Task Assigned To Me',
        horizontalLink1:   'Dashboard',
        horizontalLink2:   'Settings',
        horizontalLink3:   'Profile',
        horizontalLink4:   'Presence',
        horizontalLink5:   'Help'
    };
    var frenshLinkName = {
        verticalLink1  :   'Wiki',
        verticalLink2  :   'T\u00e0che qui m\'a \u00e9t\u00e9 assigne',
        horizontalLink1:   'Tableau de bord',
        horizontalLink2:   'Param\u00e8tres',
        horizontalLink3:   'Profil',
        horizontalLink4:   'Pr\u00e9sence',
        horizontalLink5:   'Aide'
    };
    var translateLink = function (id) {
        if($cookieStore.get("usedLanguage")=='fr'){
            var text = frenshLinkName[id];
            $rootScope.usedLanguage='fr';
            $location.path('/wiki');
        }
        else{
            var text = englishLinkName[id];
            $rootScope.usedLanguage='en';
            $location.path('/wiki');
        }
        return text ? text : '*Traduction introuvable*';
    };

    return {
        restrict: 'A',
        compile: function compile(tElement, attr, transclude){
            tElement.text(translateLink(attr.name));
            }
    }
});