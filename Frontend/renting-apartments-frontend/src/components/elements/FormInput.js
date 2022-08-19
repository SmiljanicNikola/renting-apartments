import React from 'react'
import '../../assets/css/formInput.css'


export const FormInput = (props) => {
  const {label, onChange, id, ...inputProps} = props;

  return (
    <div className="formInput">
        {/*<label>{label}</label>*/}

        <input
          {...inputProps} onChange={onChange}
        />
    </div>
  )
}
