var app = angular.module('atmApp', ['ui.router']);

app.config(function ($stateProvider, $urlRouterProvider, $provide, $locationProvider) {
    $urlRouterProvider.otherwise('login');

    $stateProvider
        .state('login', {
            url: '/login',
            templateUrl: 'app/components/login/loginView.html'
        });

    //$urlRouterProvider.html5mode(true);

});