import React, {useEffect, useRef, useState} from 'react'
import { useNavigate } from 'react-router-dom'
import RentRequestService from '../../services/RentRequestService';
import { FormInput } from '../elements/FormInput';
import '../../assets/css/register.css'
import { Button } from '../elements/ButtonElement'
import UserService from '../../services/UserService';
import styled from "styled-components";


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
    <div class="body-login">
        <MainContainer>


          <h1 style={{marginTop:'20px'}}>Register Form</h1>

          {inputs.map((input) => (
              <FormInput className='form-input inputText' key={input.id} {...input} value={values[input.name]} onChange={onChange} />
          ))}

          <span class="radio">
              <label for="active">Client:</label>
              <input type="radio" id="role" onChange={handleClientInput} name="role"/>
          </span>

          <span class="radio" style={{marginLeft:'10px'}}>
              <label for="active">Renter:</label>
              <input type="radio" id="role" onChange={handleRenterInput} name="role" />
          </span>

          <button style={{marginTop:'30px'}} onClick={registerClient} className="button-white">Submit</button>

        </MainContainer>
    </div>
    )
}


const MainContainer = styled.div`
  display: flex;
  margin-top:30px;
  align-items: center;
  flex-direction: column;
  height: 80vh;
  width: 30vw;
  background: rgba(255, 255, 255, 0.15);
  box-shadow: 0 8px 32px 0 rgba(31, 38, 135, 0.37);
  backdrop-filter: blur(8.5px);
  -webkit-backdrop-filter: blur(8.5px);
  border-radius: 10px;
  color: black;
  text-transform: uppercase;
  letter-spacing: 0.4rem;
  @media only screen and (max-width: 320px) {
    width: 80vw;
    height: 90vh;
    hr {
      margin-bottom: 0.3rem;
    }
    h4 {
      font-size: small;
    }
  }
  @media only screen and (min-width: 360px) {
    width: 80vw;
    height: 90vh;
    h4 {
      font-size: small;
    }
  }
  @media only screen and (min-width: 411px) {
    width: 80vw;
    height: 90vh;
  }
  @media only screen and (min-width: 768px) {
    width: 80vw;
    height: 80vh;
  }
  @media only screen and (min-width: 1024px) {
    width: 70vw;
    height: 50vh;
  }
  @media only screen and (min-width: 1280px) {
    width: 30vw;
    height: 80vh;
  }
`;