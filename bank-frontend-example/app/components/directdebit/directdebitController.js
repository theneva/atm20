angular.module('atmApp')
    .controller('DirectDebitCtrl', ['$scope', 'Account', 'DirectDebitPayment', function ($scope, Account, DirectDebitPayment) {
        $scope.account = Account.getInformation();

        $scope.cancelDirectDebitPayment = function (id) {
            DirectDebitPayment.cancelPayment(id).then(function () {
                alert('Payment canceled');
            });
        }

    }]);