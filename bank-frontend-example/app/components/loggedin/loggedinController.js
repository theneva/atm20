angular.module('atmApp')
    .controller('LoggedInCtrl', ['$scope', '$rootScope', '$stateParams', '$state', 'Account', function ($scope, $rootScope, $stateParams, $state, Account)
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
    }]);