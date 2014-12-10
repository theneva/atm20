angular.module('atmApp')
    .factory('DirectDebitPayment', ['$http', 'Account', 'ServiceAPI', function ($http, Account, ServiceAPI) {

        console.log("Inni DirectDebitPayment");
        return {
            cancelPayment: function (id) {
                console.log("Inni cancelPayment");
                return $http({
                    url: ServiceAPI.url + '/api/payments/' + id,
                    method: 'DELETE',
                    headers: {
                        Authorization: Account.getToken()
                    }
                });
            }
        }
    }]);