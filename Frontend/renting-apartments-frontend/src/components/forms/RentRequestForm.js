import React,{useEffect,useState} from 'react'
import '../../assets/css/register.css'
import '../../assets/css/formInput.css'
import { Button } from '../elements/ButtonElement'


export const RentRequestForm = () => {
    const[rentRequest, setRentRequest] = useState({})

    const sendRentRequest = (rentRequest) =>{
        let newRentRequest = {

        }
    }


  return (
    <div className="requestForm">
         <form className="form">
            <h1 style={{marginTop:'25px'}}>Rent Request</h1>
            <div className="formInput">
                
            <label>Client Username: </label>
            <input className='form-input-rentRequest' 
                type="text"
                name="username"
            
            />

            <label>Email of apartment Owner: </label>
            <input className='form-input-rentRequest' 
                type="text"
                name="email"
            
            />

            <label>Start Date: </label>
            <input className='form-input-rentRequest' type="date"
            
            />

            <label>End Date: </label>
            <input className='form-input-rentRequest' type="date"
            
            />

            <label>Additional Message: </label>
            <input className='form-input-rentRequest' type="text" name="additionalMessage" id="additionalMessage"
            
            />


            </div>
            <button className="button-rentRequest">Submit</button>
        </form>
    </div>
  )
}
