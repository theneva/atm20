angular.module('atmApp')
    .controller('DirectDebitCtrl', ['$scope', 'Account', 'DirectDebitPayment', function ($scope, Account, DirectDebitPayment) {
        $scope.account = Account.getInformation();

        $scope.cancelDirectDebitPayment = function (payment) {
            DirectDebitPayment.cancelPayment(payment);
        }

    }]);