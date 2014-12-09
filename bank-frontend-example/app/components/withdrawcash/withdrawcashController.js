angular.module('atmApp')
    .controller('WithdrawCashCtrl', ['$scope', 'Account', function ($scope, Account) {
        $scope.account = Account.getInformation();
    }]);