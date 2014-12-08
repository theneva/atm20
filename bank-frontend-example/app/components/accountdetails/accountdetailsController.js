angular.module('atmApp')
    .controller('AccountDetailsCtrl', ['$scope', 'Account', function ($scope, Account)
    {
        $scope.account = Account.getInformation();

        console.log($scope.account);
    }]);