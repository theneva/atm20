var app = angular.module('atmApp', ['ui.router']);

app.config(function ($stateProvider, $urlRouterProvider, $provide, $locationProvider) {
    $urlRouterProvider.otherwise('login');

    $stateProvider
        .state('login', {
            url: '/login',
            templateUrl: 'app/components/login/loginView.html'
        })
        .state('loggedin', {
            url: '/logged-in',
            templateUrl: 'app/components/loggedin/loggedinView.html'
        })
        .state('withdrawcash', {
            url: '/withdraw-cash',
            templateUrl: 'app/components/withdrawcash/withdrawcashView.html'
        });

    //$urlRouterProvider.html5mode(true);

});