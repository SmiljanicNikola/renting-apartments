import React from 'react'
import { Link } from 'react-router-dom';


function AdvertiseItem(props) {
    return (
        <>
            <li className="cards__item">
                <Link className="cards__item__link" to={props.path}>
                    <figure className="cards__item__pic-wrap" data-category={props.label} data-category2={props.label2}>
                        <img
                        src={props.src}
                        alt="Imageee"
                        className="cards__item__img"
                        />
                    </figure>
                    <div className="cards__item__info">
                        <h5 className='cards__item__text'>{props.text}</h5>
                        <h5 className='cards__item__text'>{props.text1}</h5>
                        <h5 className='cards__item__text'>{props.text2}</h5>

                    </div>

                </Link>  
            </li>  
        </>
    );
}

export default AdvertiseItem;
