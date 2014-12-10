angular.module('atmApp')
    .factory('Authentication', ['$http', 'ServiceAPI', function ($http, ServiceAPI)
    {
        return {
            verify: function (accountNumber, pinNumber)
            {

                var account = {
                    accountNumber: accountNumber,
                    pin: pinNumber
                };

                return $http.post(ServiceAPI.url + '/api/sessions', account);
            },
            retainCard: function (accountNumber) {
                var account = {
                    accountNumber: accountNumber
                };

                return $http.post(ServiceAPI.url + '/api/retainCard', account);
            },
            destroySession: function (token) {
                return $http({
                    url: ServiceAPI.url + '/api/sessions',
                    method: 'DELETE',
                    headers: {
                        Authorization: token
                    }
                });
            }
        }
    }]);