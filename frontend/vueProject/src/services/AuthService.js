import http from "../http-common";

import authHeader from './authJwt/auth-header';

class AuthService {

    userLogin(user) {
        return http.post(`/login`, user);
    }

    logout(){
        return http.get(`/logout`, { headers: authHeader() });
    }
}

export default new AuthService();