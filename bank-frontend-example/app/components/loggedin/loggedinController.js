angular.module('atmApp')
.controller('LoggedInCtrl', ['$scope', function ($scope) {

        //$scope.accountBalanceInvisible = true;
        $scope.revealButtonInvisible = false;

        $scope.revealBalance = function () {
            $scope.revealButtonInvisible = true;
        };

        $scope.hideBalance = function () {
            $scope.revealButtonInvisible = false;
        };
    }]);