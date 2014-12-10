angular.module('atmApp')
    .controller('LoggedInCtrl', ['$scope', '$rootScope', '$stateParams', '$state', '$http', 'Account', 'Authentication', function ($scope, $rootScope, $stateParams, $state, $http, Account, Authentication)
    {
        $scope.account = Account.getInformation();

        if (JSON.stringify($scope.account) == '{}') {
            $state.go('login');
        }

        $scope.toggleButtonVisibilityBool = false;

        $scope.toggleButtonVisibility = function ()
        {
            $scope.toggleButtonVisibilityBool = !$scope.toggleButtonVisibilityBool;
        };

        $scope.logout = function () {
            Authentication.destroySession(Account.getToken()).then(function () {
                $state.go('login');
            });
        }

    }]);