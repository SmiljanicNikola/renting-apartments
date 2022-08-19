import React, {useEffect, useRef, useState} from 'react'
import { useNavigate } from 'react-router-dom'
import RentRequestService from '../../services/RentRequestService';
import { FormInput } from '../elements/FormInput';
import '../../assets/css/register.css'
import { Button } from '../elements/ButtonElement'
import UserService from '../../services/UserService';


export const Register = () => {
    //const [username, setUsername] = useState(""); //Ovo zakomentarisemo jer na svako promenjeno slovo nam rerenderuje komponentu
    const [values, setValues] = useState({
        name:'',
        lastname:'',
        username:'',
        password:'',
        confirmPassword:'',
        phoneNumber:'',
        email:''
    })
    const [clientRole, setClientRole] = useState(Boolean);
    const [renterRole, setRenterRole] = useState(Boolean);

    const inputs = [
        
        {
            id:1,
            name:"name",
            type:"text",
            placeholder:"name",
            label:"name"
        },
        {
            id:2,
            name:"lastname",
            type:"text",
            placeholder:"lastname",
            label:"lastname"
        },
        {
            id:3,
            name:"username",
            type:"text",
            placeholder:"username",
            label:"username"
        },
        {
            id:4,
            name:"password",
            type:"password",
            placeholder:"password",
            label:"password"
        },
        {
            id:5,
            name:"confirmPassword",
            type:"password",
            placeholder:"confirmPassword",
            label:"confirmPassword"
        },
        {
            id:6,
            name:"phoneNumber",
            type:"text",
            placeholder:"phoneNumber",
            label:"phoneNumber"
        },
        {
            id:7,
            name:"email",
            type:"text",
            placeholder:"email",
            label:"email"
        }
    ]

    const handleSubmit = (e) =>{
        e.preventDefault();
        console.log(values)
        UserService.registerClient(values);
    }

    const onChange = (e) => {
        setValues({...values, [e.target.name]: e.target.value}); 
    }

    const registerClient = (e) =>{
        e.preventDefault();

        if(clientRole){
            console.log(values)
            UserService.registerClient(values);
        }else{
            UserService.registerRenter(values);
        }
    }

    const handleClientInput = (e) => {
        setClientRole(true);
        setRenterRole(false)
        
    }

    const handleRenterInput = (e) => {
        setRenterRole(true);
        setClientRole(false)
        
    }

  return (
    <div className="requestForm">
        <form className="form">

            <h1 style={{marginTop:'20px'}}>Register Form</h1>

            {inputs.map((input) => (
                <FormInput className='form-input' key={input.id} {...input} value={values[input.name]} onChange={onChange} />
            ))}

            <span class="radio">
                <label for="active">Client:</label>
                <input type="radio" id="role" onChange={handleClientInput} name="role"/>
            </span>

            <span class="radio" style={{marginLeft:'10px'}}>
                <label for="active">Renter:</label>
                <input type="radio" id="role" onChange={handleRenterInput} name="role" />
            </span>

            <button style={{marginTop:'30px'}} onClick={registerClient}>Submit</button>

        </form>  
    </div>
    )
}
