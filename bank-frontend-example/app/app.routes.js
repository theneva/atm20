var app = angular.module('atmApp', ['ui.router']);

app
    .config(function ($stateProvider, $urlRouterProvider, $httpProvider)
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
                templateUrl: 'app/components/withdrawcash/withdrawcashView.html',
                controller: 'WithdrawCashCtrl'
            })
            .state('directdebit', {
                url: '/direct-debit',
                templateUrl: 'app/components/directdebit/directdebitView.html',
                controller: 'DirectDebitCtrl'
            })
            .state('transfercash', {
                url: '/transfer-cash',
                templateUrl: 'app/components/transfercash/transfercashView.html',
                controller: 'TransferCashCtrl'
            })
            .state('paybill', {
                url: '/pay-bill',
                templateUrl: 'app/components/paybill/paybillView.html',
                controller: 'PayBillCtrl'
            })
        ;

        //$urlRouterProvider.html5mode(true);

    })
    .factory('HttpRequestInterceptor', function ()
    {
        return {
            request: function (config, token)
            {

                // use this to destroying other existing headers
                config.headers = {'Authorization': token};

                // use this to prevent destroying other existing headers
                // config.headers['Authorization'] = 'authentication;

                return config;
            }
        };
    })
    .factory('Account', ['$http', 'ServiceAPI', function ($http, ServiceAPI)
    {
        var loggedInAccount = {};
        var sessionToken = "";

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
            setToken: function (token)
            {
                console.log(token);
                sessionToken = token;
                return token;
            },
            getToken: function ()
            {
                return sessionToken;
            },
            updateAccount: function (account)
            {
                return $http({
                    url: ServiceAPI.url + '/api/accounts',
                    method: 'PUT',
                    headers: {
                        Authorization: this.getToken()
                    },
                    data: account
                })
            }
        }
    }])
    .factory('ServiceAPI', [function ()
    {
        return {
          url: 'http://localhost:8080/atm20'
        }
    }])
    .run(function ($rootScope, $location, $http, $timeout)
    {
        $rootScope.globalServicesDoh = "Doh";
    });
