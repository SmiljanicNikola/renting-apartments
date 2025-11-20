import React from 'react';
import { Link } from 'react-router-dom';

function AdvertiseItem(props) {
  const { advertisement, src, text, text1, text2 } = props;

  // Create dynamic path to detail page
  const detailPath = `/advertisement/1`;

  return (
    <li className="cards__item">
      <Link className="cards__item__link" to={detailPath}>
        <div className="cards__item__pic-wrap">
          <img
            src={src}
            alt="Apartment"
            className="cards__item__img"
          />
        </div>
        <div className="cards__item__info">
          <h5 className="cards__item__text">{text}</h5>
          <h5 className="cards__item__text">{text1}</h5>
          <h5 className="cards__item__text">{text2}</h5>
        </div>
      </Link>
    </li>
  );
}

export default AdvertiseItem;