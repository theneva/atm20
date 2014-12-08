var app = angular.module('atmApp', ['ui.router']);

app
    .config(function ($stateProvider, $urlRouterProvider, $provide, $locationProvider)
    {
        $urlRouterProvider.otherwise('login');

        $stateProvider
            .state('login', {
                url: '/login',
                templateUrl: 'app/components/login/loginView.html',
                controller: 'LoginCtrl'
            })
            .state('loggedin', {
                url: '/logged-in/:data',
                templateUrl: 'app/components/loggedin/loggedinView.html',
                controller: 'LoggedInCtrl'
            })
            .state('accountdetails', {
                url: '/account-details',
                templateUrl: 'app/components/accountdetails/accountdetailsView.html',
                controller: 'AccountDetailsCtrl'
            })
            .state('withdrawcash', {
                url: '/withdraw-cash',
                templateUrl: 'app/components/withdrawcash/withdrawcashView.html'
            })
        ;

        //$urlRouterProvider.html5mode(true);

    })
    .factory('Account', ['$http', function ($http)
    {
        var loggedInAccount = {};

        return {
            setInformation: function (account)
            {
                loggedInAccount = account;
                return account;
            },
            getInformation: function ()
            {
                return loggedInAccount;
            },
            updateWrongPinCount: function (accountInfo) {

                $http.post('/api', { /*AccountNumber*/ });
            }
        }
    }])
    .run(function ($rootScope, $location, $http, $timeout)
    {
        $rootScope.globalServicesDoh = "Doh";
    });