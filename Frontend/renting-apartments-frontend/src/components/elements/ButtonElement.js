import styled from "styled-components";
import { Link } from "react-scroll";

export const Button = styled(Link)`
    border-radius:50px;
    background: ${({primary}) => (primary ? '#01BF71' : 'rgb(0, 33, 65);')};
    white-space:nowrap;
    padding:${({big}) => (big ? '14px 48px' : '12px 30px')};
    color:${({dark}) => (dark ? 'rgb(0, 33, 65);' : '#fff')};
    font-size: ${({fontBig}) => (fontBig ? '20px' : '16px')};
    outline:none;
    border:none;
    cursor:pointer;
    display:flex;
    justify-content:center;
    align-items:center;
    text-decoration:none;
    margin-right:5px;
    transition: all 0.2s ease-in-out;

    &:hover{
        transition: all 0.2s ease-in-out;
        background:#01BF71;
    };

    }
`;

export const ButtonDelete = styled(Link)`
    border-radius:50px;
    background: ${({primary}) => (primary ? '#01BF71' : 'rgb(205,92,92)')};
    white-space:nowrap;
    padding:${({big}) => (big ? '14px 48px' : '12px 30px')};
    color:${({dark}) => (dark ? 'rgb(0, 33, 65);' : '#fff')};
    font-size: ${({fontBig}) => (fontBig ? '20px' : '16px')};
    outline:none;
    border:none;
    cursor:pointer;
    display:flex;
    justify-content:center;
    align-items:center;
    text-decoration:none;
    margin-right:5px;
    transition: all 0.2s ease-in-out;

    &:hover{
        transition: all 0.2s ease-in-out;
        background:#01BF71;
    };

    }
`;