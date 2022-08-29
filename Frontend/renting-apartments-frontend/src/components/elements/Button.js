import styled from "styled-components";

export default function Button({ content }) {
  return <StyledButton>{content}</StyledButton>;
}

const StyledButton = styled.button`
background: rgb(0, 33, 65);
text-transform: uppercase;
  letter-spacing: 0.2rem;
  width: 45%;
  height: 4rem;
  border: none;
  color: white;
  border-radius: 2rem;
  cursor: pointer;
`;
