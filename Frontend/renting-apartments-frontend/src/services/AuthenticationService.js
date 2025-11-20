import axios from 'axios'
import { TokenService } from './TokenService';

const AUTH_REST_API_URL =  `${process.env.REACT_APP_BACKEND_URL}/api/auth`;

export const AuthenticationService = {
    login,
    logout,
    getRole,
    getUsername,
    registerClient,
    registerRenter
};

async function login(userCredentials){

    try{
        const response = await axios.post(AUTH_REST_API_URL+"/login",userCredentials);
        const decoded_token = TokenService.decodeToken(response.data.token);
        if (decoded_token) {
          TokenService.setToken(response.data.token);
          window.location.assign("/apartments");
          console.log(response.data.username);
    
        } else {
          console.error("Invalid token");
        }
      } catch (error) {
        console.error(error);
      }    
}

function logout() {
    TokenService.removeToken();
    window.location.reload();
    window.location.assign("/login");
}

function getRole(){
    const token = TokenService.getToken();
    const decoded_token = token ? TokenService.decodeToken(token):null;
    if(decoded_token){
        return decoded_token.role.authority;
    } else{
        return null;
    }
}

function getUsername() {
    const token = TokenService.getToken();
    const decoded_token = token ? TokenService.decodeToken(token) : null;
    if (decoded_token) {
      return decoded_token.sub
    } else {
      return null;
    }
  }

  function registerClient(client) {
    return axios.post(AUTH_REST_API_URL + '/register/client', client);
}

function registerRenter(renter) {
    return axios.post(AUTH_REST_API_URL + '/register/renter', renter);
}