import styled from "styled-components";
import { Link } from "react-scroll";

export const Button = styled(Link)`
    border-radius:30px;
    background: rgb(0, 33, 65);
    white-space:nowrap;
    padding:12px 30px;
    color:#fff;
    font-size:16px;
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
        transition: all 0.4s ease-in-out;
        background:#01BF71;
    };
`;

export const ButtonDelete = styled(Link)`
    border-radius:30px;
    background: rgb(205,92,92);
    white-space:nowrap;
    padding:12px 30px;
    color:#fff;
    font-size:16px;
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
        transition: all 0.4s ease-in-out;
        background:#01BF71;
    };
`;