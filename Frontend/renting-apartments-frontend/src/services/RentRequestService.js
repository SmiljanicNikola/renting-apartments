import axios from 'axios'

const RENT_REQUESTS_REST_API_URL = `${process.env.REACT_APP_BACKEND_URL}/api/rentRequests`

class RentRequestService{

    getRentRequests(){
        return axios.get(RENT_REQUESTS_REST_API_URL);
    }

}

export default new RentRequestService();