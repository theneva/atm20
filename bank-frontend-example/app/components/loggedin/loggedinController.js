angular.module('atmApp')
    .controller('LoggedInCtrl', ['$scope', '$rootScope', '$stateParams', '$state', '$http', 'Account', 'Authentication', function ($scope, $rootScope, $stateParams, $state, $http, Account, Authentication)
    {
        $scope.account = Account.getInformation();

        if (JSON.stringify($scope.account) == '{}') {
            $state.go('login');
        }


        console.log($scope.account);


        $scope.toggleButtonVisibilityBool = false;

        $scope.toggleButtonVisibility = function ()
        {
            $scope.toggleButtonVisibilityBool = !$scope.toggleButtonVisibilityBool;
        };

        $scope.testAccount = function () {
            $http({
                url: 'http://10.21.24.126:8081/presentation-1.0.0-SNAPSHOT/api/accounts',
                method: 'GET',
                headers: {
                    Authorization: Account.getToken()
                }
            })
                .success(function (response) {
                    console.log(response);
                })
                .error(function (err) {
                    alert(err);
                })
        };

        $scope.logout = function () {
            Authentication.destroySession(Account.getToken()).then(function () {
                $state.go('login');
            });
        }

    }]);