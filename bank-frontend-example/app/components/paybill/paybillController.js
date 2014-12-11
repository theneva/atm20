angular.module('atmApp')
    .controller('PayBillCtrl', ['$scope', 'Account', 'PayBill', function ($scope, Account, PayBill)
    {
        $scope.account = Account.getInformation();

        $scope.alert = {
            alertColor: '',
            alertHeading: '',
            alertBody: ''
        };

        $scope.showMessage = false;

        $scope.bill = {
            amount: 0,
            dueDate: '',
            recipientAccountNumber: '',
            recipientNickname: '',
            kid: ''
        };

        $scope.payBill = function ()
        {
            PayBill.pay($scope.bill).then(function (result)
            {
                $scope.account.pendingPayments.push(result.data);
                Account.setInformation($scope.account);

                showMessage('green', 'Success!', 'You paid the bill successfully.');

            }, function (err)
            {
                if (err.status == 400)
                {
                    showMessage('red', 'Fail!', err.data.message);

                } else if (err.status == 402) {
                    showMessage('red', 'Fail!', err.data.message);
                }

            });
        };

        $scope.closeAlert = function () {
            $scope.showMessage = false;
        };

        $scope.clearFields = function () {
            $scope.bill = {
                amount: 0,
                dueDate: '',
                recipientAccountNumber: '',
                recipientNickname: '',
                kid: ''
            };
        };

        function showMessage (color, heading, body) {
            $scope.showMessage = true;
            $scope.alert.alertColor = color;
            $scope.alert.alertHeading = heading;
            $scope.alert.alertBody = body;
        }

    }]);