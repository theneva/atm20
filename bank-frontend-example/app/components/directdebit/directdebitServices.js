angular.module('atmApp')
    .factory('DirectDebitPayment', ['$http', function ($http) {

        return {
            cancelPayment: function (debitPayment) {
                $http.post('http://localhost:8080/api/cancelDebitPayment', debitPayment);
            }
        }
    }]);