const displayPaginated = async (pageNumber, size, getItemsFunc, displayItemsFunc) => {

    getItemsFunc(pageNumber, size).then(response => {
        displayItemsFunc(response.data.content);
    });
}

const displayPaginatedByTeamMember = async (teamMemberId, pageNumber, size, getItemsFunc, displayItemsFunc) => {

    getItemsFunc(teamMemberId,pageNumber, size).then(response => {
        displayItemsFunc(response.data.content);
    });
}

const PaginationHelper = {
    displayPaginated,
    displayPaginatedByTeamMember
 };

export default PaginationHelper

export {
    displayPaginated,
    displayPaginatedByTeamMember
}