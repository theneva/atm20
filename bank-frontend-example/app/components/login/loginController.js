angular.module('atmApp')
    .controller('LoginCtrl', ['$scope', '$rootScope', '$document', '$http', '$state', 'Account', 'Authentication', function ($scope, $rootScope, $document, $http, $state, Account, Authentication)
    {

        var requestHasBeenSent = false;

        resetForm();
        $scope.infoWrongCount = 0; // The amount of times a user has entered his/her information wrong (3 = retain card)
        $scope.enteredWrongInfoThreeTimes = false;

        $scope.enterPinOrAccountNumber = function (number)
        {
            // Switch between input the two fields based on the amount of entered characters
            if ($scope.accountNumber.length < 11)
            {
                $scope.accountNumber += number;
            }
            else
            {
                $scope.pin += number;
                $scope.hasPinBeenEntered();
            }
        };

        $scope.clearPin = function ()
        {
            $scope.accountNumber = "";
            $scope.pin = "";
        };

        $scope.resetForm = function ()
        {
            resetForm();
        };

        $scope.autologin = function ()
        {
            Authentication.verify('55555555555', '5555')
                .then(function (response)
            {
                return response;
            })
                .then(function (response)
            {
                if (typeof response != 'undefined')
                {
                    var headers = response.headers();
                    var data = response.data;

                    Account.setToken(headers['authorization']);
                    Account.setInformation(data);
                    $state.go('loggedin');
                }
            });
        };

        $scope.hasPinBeenEntered = function ()
        {
            if ($scope.pin.length == 4 && $scope.accountNumber.length == 11)
            {
                $scope.disableKeypad = "disabled";

                if (!requestHasBeenSent)
                {
                    Authentication.verify($scope.accountNumber, $scope.pin)
                        .then(function (response)
                    {
                        return response;
                    }, function (err)
                    {
                        console.log(err);
                        if (err.status == 401)
                        {
                            registerWrongPin();
                        } else if (err.status == 423)
                        {
                            retainCard();
                        } else if (err.status == 0)
                        {
                            alert('The server is currently offline.');
                        }
                    })
                        .then(function (response)
                    {
                        if (typeof response != 'undefined')
                        {
                            var headers = response.headers();
                            var data = response.data;

                            if (data.message !== "No such account" || data.message !== "Invalid PIN")
                            {
                                Account.setToken(headers['authorization']);
                                Account.setInformation(data);
                                $state.go('loggedin');
                            }
                            else
                            {
                                registerWrongPin();
                            }
                        }
                    });
                    requestHasBeenSent = true;
                }
                return true;
            }
        };

        $scope.resetATM = function ()
        {
            resetForm();
            $scope.enteredWrongInfoThreeTimes = false;
        };

        function retainCard()
        {
            $scope.wasInfoWrong = false;
            $scope.enteredWrongInfoThreeTimes = true;
        }

        function registerWrongPin()
        {
            $scope.wasInfoWrong = true;
        }

        function resetForm()
        {
            $scope.disableKeypad = "";      // Becomes "disabled" for CSS-disabling
            $scope.pin = "";                // Pin code
            $scope.accountNumber = "";      // Account number
            $scope.wasInfoWrong = false;    // If the entered information was wrong
            requestHasBeenSent = false;     // Resets the requests count
        }
    }]);