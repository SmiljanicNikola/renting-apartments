import axios from 'axios'

const USERS_REST_API_URL = `${process.env.REACT_APP_BACKEND_URL}/api/users`

class UserService{

    getUsers(){
        return axios.get(USERS_REST_API_URL);
    }

    registerClient(client){
        return axios.post(USERS_REST_API_URL+'/client', client);
    }

    registerRenter(renter){
        return axios.post(USERS_REST_API_URL+'/renter', renter);
    }


}

export default new UserService();