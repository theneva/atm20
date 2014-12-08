angular.module('atmApp')
    .controller('LoginCtrl', ['$scope', '$rootScope', '$document', '$http', '$state', 'Account', 'VerifyPin', function ($scope, $rootScope, $document, $http, $state, Account, VerifyPin)
    {

        var requestHasBeenSent = false;

        resetForm();
        $scope.infoWrongCount = 0; // The amount of times a user has entered his/her information wrong (3 = retain card)
        $scope.enteredWrongInfoThreeTimes = false;

        $scope.enterPinOrAccountNumber = function (number)
        {
            console.log($scope.accountNumber.length);

            // Switch between input the two fields based on the amount of entered characters
            if ($scope.accountNumber.length < 11) {
                $scope.accountNumber += number;
            } else {
                $scope.pin += number;
                $scope.hasPinBeenEntered();
            }
        };

        $scope.clearPin = function () {
            $scope.pin = "";
        };

        $scope.resetForm = function () {
            resetForm();
        };

        $scope.hasPinBeenEntered = function ()
        {
            if ($scope.pin.length == 4 && $scope.accountNumber.length == 11)
            {
                $scope.disableKeypad = "disabled";

                if (!requestHasBeenSent)
                {
                    VerifyPin.verify($scope.accountNumber, $scope.pin)
                        .then(function (result)
                        {
                            return result.data;
                        })
                        .then(function (data)
                        {
                            if (data.message !== "NOPE")
                            {
                                Account.setInformation(data);
                                $state.go('loggedin');
                            }
                            else
                            {
                                // Info entered was wrong
                                console.log("WRONG");
                                $scope.infoWrongCount += 1;
                                if ($scope.infoWrongCount == 3) {
                                    Account.updateWrongPinCount('');
                                    $scope.wasInfoWrong = false;
                                    $scope.enteredWrongInfoThreeTimes = true;
                                    //alert('Three wrongs ain\'t no right!');
                                } else {
                                    $scope.wasInfoWrong = true;
                                }

                            }
                        });
                    requestHasBeenSent = true;
                }
                return true;
            }
        };

        function resetForm() {
            $scope.disableKeypad = "";      // Becomes "disabled" for CSS-disabling
            $scope.pin = "";                // Pin code
            $scope.accountNumber = "";      // Account number
            $scope.wasInfoWrong = false;    // If the entered information was wrong
            requestHasBeenSent = false;     // Resets the requests count
        }

        $scope.resetATM = function () {
            resetForm();
            $scope.enteredWrongInfoThreeTimes = false;
        }
    }]);