angular.module('atmApp')
    .controller('AccountDetailsCtrl', ['$scope', 'Account', function ($scope, Account)
    {
        $scope.account = Account.getInformation();
        $scope.showMessage = false;

        $scope.alert = {
            alertColor: '',
            alertHeading: '',
            alertBody: ''
        };

        $scope.updateAccountInformation = function ()
        {
            var changedAccount = {
                firstName: $scope.account.personalDetails.firstName,
                lastName: $scope.account.personalDetails.lastName,
                address: $scope.account.personalDetails.address,
                postalCode: $scope.account.personalDetails.postalCode,
                region: $scope.account.personalDetails.region,
                state: $scope.account.personalDetails.state
            };

            Account.updateAccount(changedAccount)
                .then(function (result)
                {
                    Account.setInformation(result);
                    showMessage('green', 'Success', 'Your account details have been updated');

                }, function (err)
                {
                    showMessage('red', 'Fail', err.data.message);
                });
        };

        function showMessage (color, heading, body) {
            $scope.showMessage = true;
            $scope.alert.alertColor = color;
            $scope.alert.alertHeading = heading;
            $scope.alert.alertBody = body;
        }

    }]);