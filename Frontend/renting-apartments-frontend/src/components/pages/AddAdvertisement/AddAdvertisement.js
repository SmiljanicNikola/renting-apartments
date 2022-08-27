import React,{useEffect, useState} from 'react'
import AdvertisementService from '../../../services/AdvertisementService.js';
import ApartmentService from '../../../services/ApartmentService.js';
import '../../../assets/css/advertisement.css'

export const AddAdvertisement = () => {
    const [advertisement, setAdvertisement] = useState({});
    const [apartments, setApartments] = useState([]);
    const [valueApartment, setValueApartment] = useState('');

const fetchApartments = () => {
		ApartmentService.getApartments().then(( response ) => {
			setApartments(response.data);
            console.log(apartments)
		})
	}

    const handleChangeApartment = apartment =>{
        setValueApartment(apartment.target.value);
        
    }

  return (
    <div className="requestForm">
         <form className="form">
            <h1 style={{marginTop:'25px'}}>Add Advertisement</h1>
            <div className="formInput">
                
            <label>Renter Username: </label>
            <input className='form-input-rentRequest' 
                type="text"
                name="username"
                
            />

            <label>Email of apartment Owner: </label>
            <input className='form-input-rentRequest' 
                type="text"
                name="email"
            
            />

            <label>Apartment:</label><br></br>
                <select name="apartment"
                    onChange={handleChangeApartment}
                    onClick={fetchApartments}
                    >

                    <option>Select Apartment</option>
                    {
                    apartments.map((apartment) => (
                        <option
                        onClick={handleChangeApartment}
                        getOptionValue={apartment => apartment.id}
                        value={apartment.id}
                        key={apartment.id}
                        > {apartment.apartmentName + " " + apartment.address} </option>
                        ))
                    }

                </select>

          
            <br></br>
            <label>Price </label>
            <input className='form-input-rentRequest' type="text" name="additionalMessage" id="additionalMessage"
            
            />


            </div>
            <button className="button-rentRequest">Submit</button>
        </form>
    </div>
  )
}
