angular.module('atmApp')
    .directive('homeButton', function () {
       return {
           restrict: 'AEC',
           template: '<button ui-sref="loggedin" class="ui orange circular button"><i class="arrow left icon"></i> Return to overview</button>'
       }
    });