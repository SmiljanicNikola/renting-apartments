import React from 'react'
import { Link } from 'react-router-dom'
import { Button } from '../elements/ButtonElement'
import '../../assets/css/footer.css'


export const Footer = () => {
  return (
    <div className='footer-container'>
    <section className="footer-subscription">
        <p className="footer-subscription-heading">
            Join us on our platform to recieve our best deals and prices!
        </p>
        <p className="footer-subscription-text">
            You can always join us, the earlier the better.
        </p>
        <div className="input-areas">
            <form>
                <input type="email" name="email" placeholder="Your email" className="footer-input"/>
                <Button buttonStyle='btn--outline'>Subscribe</Button>
            </form>
        </div>
    </section>
    <div className='footer-links'>
        <div className='footer-link-wrapper'>
            <div className='footer-link-items'>
                <h2>About Us</h2>
                <Link to='/sign-up'>How it works</Link>
                <Link to='/'>Testimonials</Link>
                <Link to='/'>Purchase</Link>
                <Link to='/'>About Us</Link>
                <Link to='/'>Contact</Link>
            </div>
            <div className='footer-link-items'>
                <h2>About Us</h2>
                <Link to='/sign-up'>How it works</Link>
                <Link to='/'>Testimonials</Link>
                <Link to='/'>Testimonials</Link>
                <Link to='/'>Testimonials</Link>
                <Link to='/'>Testimonials</Link>
            </div>
        </div>
        <div className='footer-link-wrapper'>
            <div className='footer-link-items'>
                <h2>About Us</h2>
                <Link to='/sign-up'>How it works</Link>
                <Link to='/'>Testimonials</Link>
                <Link to='/'>Purchase</Link>
                <Link to='/'>About Us</Link>
                <Link to='/'>Contact</Link>
            </div>
            <div className='footer-link-items'>
                <h2>About Us</h2>
                <Link to='/sign-up'>How it works</Link>
                <Link to='/'>Testimonials</Link>
                <Link to='/'>Testimonials</Link>
                <Link to='/'>Testimonials</Link>
                <Link to='/'>Testimonials</Link>
            </div>
        </div>
    </div>

    <section className="social-media">
        <div className="social-media-wrap">
            <div className="footer-logo">
                <Link to='/' className="social-logo">
                    APART <i className='fab fa-typo3'/>

                
                </Link>
            </div>
            <small className="website-rights">Travel 2020 @Copyright</small>
            <div className="social-icons">
                <Link className="social-icon-link facebook"
                to="/"
                target="_blank"
                aria-label='Facebook'
                >
                    <i className="fab fa-facebook f"></i>
                </Link>
                <Link className="social-icon-link instagram"
                to="/"
                target="_blank"
                aria-label='Instagram'
                >
                    <i className="fab fa-instagram"></i>
                </Link>
                <Link className="social-icon-link twitter"
                to="/"
                target="_blank"
                aria-label='Twitter'
                >
                    <i className="fab fa-twitter"></i>
                </Link>
            </div>
        </div>
    </section>




</div>
  )
}
