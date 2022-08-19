import axios from 'axios'

const RENTERS_REST_API_URL = `${process.env.REACT_APP_BACKEND_URL}/api/renters`

class RenterService{

    getRenters(){
        return axios.get(RENTERS_REST_API_URL);
    }

}

export default new RenterService();