angular.module('atmApp')
    .controller('DirectDebitCtrl', ['$scope', 'Account', 'DirectDebitPayment', function ($scope, Account, DirectDebitPayment) {
        $scope.account = Account.getInformation();

        $scope.cancelDirectDebitPayment = function (id, listIndex) {
            DirectDebitPayment.cancelPayment(id).then(function () {
                $scope.account.pendingPayments.splice(listIndex, 1);

                // Update account
                Account.setInformation($scope.account);
            });
        }

    }]);