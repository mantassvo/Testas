import {
  getAllCarOwners,
  updateCarOwner,
  deleteCarOwnerById,
} from "../../commons/requests.js";

let tableParentDivId = undefined;

export const renderCarOwnerTable = async (targetId) => {
  tableParentDivId = targetId;
  const carOwners = await getAllCarOwners();
  if (document.getElementById("carOwnerTable")) {
    document.getElementById("carOwnerTable").remove();
  }
  const table = document.createElement("table");
  table.id = "carOwnerTable";
  table.className = "table table-striped";

  renderCarOwnerTableHeaders(table);
  const tbody = document.createElement("tbody");
  carOwners.forEach((owner) => {
    renderCarOwnerTableRow(tbody, owner);
  });

  table.appendChild(tbody);
  document.getElementById(tableParentDivId).appendChild(table);
};

const renderTableCell = (innerText, className) => {
  const td = document.createElement("td");
  if (innerText) {
    td.innerText = innerText;
  }
  if (className) {
    td.className = className;
  }
  return td;
};

const renderTableHeader = (innerText) => {
  const th = document.createElement("th");
  th.innerText = innerText;
  return th;
};

const renderActionButtons = (actionsCell, id) => {
  const editButton = document.createElement("button");
  editButton.innerText = "Edit";
  editButton.className = "btn btn-warning editButton";
  editButton.addEventListener("click", () => {
    handleEdit(id);
  });

  const editButton2 = document.createElement("button");
  editButton2.innerText = "Edit2";
  editButton2.className = "btn btn-warning editButton2";
  editButton2.addEventListener("click", () => {
    handleEdit2(id);
  });

  const deleteButton = document.createElement("button");
  deleteButton.innerText = "Delete";
  deleteButton.className = "btn btn-danger deleteButton";
  deleteButton.addEventListener("click", () => {
    handleDelete(id);
  });

  actionsCell.append(editButton, editButton2, deleteButton);
};

const handleEdit2 = async (id) => {
  window.location.replace(`/pages/car-owner-edit/car-owner-edit.html?id=${id}`);
};

const handleEdit = async (id) => {
  const tr = document.getElementById(`owner-${id}`);

  const companyNameCell = tr.querySelector(".companyNameCell");
  const companyNameInput = document.createElement("input");
  companyNameInput.type = "text";
  companyNameInput.value = companyNameCell.innerText;
  companyNameCell.innerText = "";
  companyNameCell.appendChild(companyNameInput);

  const addressCell = tr.querySelector(".addressCell");
  const addressInput = document.createElement("input");
  addressInput.type = "text";
  addressInput.value = addressCell.innerText;
  addressCell.innerText = "";
  addressCell.appendChild(addressInput);

  const phoneNoCell = tr.querySelector(".phoneNoCell");
  const phoneNoInput = document.createElement("input");
  phoneNoInput.type = "text";
  phoneNoInput.value = phoneNoCell.innerText;
  phoneNoCell.innerText = "";
  phoneNoCell.appendChild(phoneNoInput);

  const actionsCell = tr.querySelector(".actionsCell");
  actionsCell.querySelector(".editButton").remove();
  actionsCell.querySelector(".editButton2").remove();
  actionsCell.querySelector(".deleteButton").remove();

  const saveButton = document.createElement("button");
  saveButton.innerText = "Save";
  saveButton.className = "btn btn-success saveButton";
  saveButton.addEventListener("click", () => {
    handleUpdate(id);
  });

  const cancelButton = document.createElement("button");
  cancelButton.innerText = "Cancel";
  cancelButton.className = "btn btn-danger cancelButton";
  cancelButton.addEventListener("click", () => {
    window.location.reload();
  });

  actionsCell.append(saveButton, cancelButton);
};

const handleUpdate = async (id) => {
  const tr = document.getElementById(`owner-${id}`);
  const companyNameCell = tr.querySelector(".companyNameCell");
  const companyNameInput = companyNameCell.querySelector("input");

  const addressCell = tr.querySelector(".addressCell");
  const addressInput = addressCell.querySelector("input");

  const phoneNoCell = tr.querySelector(".phoneNoCell");
  const phoneNoInput = phoneNoCell.querySelector("input");

  const carOwner = {
    companyName: companyNameInput.value,
    address: addressInput.value,
    phoneNo: phoneNoInput.value,
  };

  await updateCarOwner(carOwner, id);
  await renderCarOwnerTable(tableParentDivId);
};

const handleDelete = async (id) => {
  await deleteCarOwnerById(id);
  await renderCarOwnerTable(tableParentDivId);
};

const renderCarOwnerTableRow = (tbody, owner) => {
  const tr = document.createElement("tr");
  tr.id = `owner-${owner.id}`;
  const companyNameCell = renderTableCell(owner.companyName, "companyNameCell");
  const addressCell = renderTableCell(owner.address, "addressCell");
  const phoneNoCell = renderTableCell(owner.phoneNo, "phoneNoCell");
  const actionsCell = renderTableCell(undefined, "actionsCell");
  renderActionButtons(actionsCell, owner.id);

  tr.append(companyNameCell, addressCell, phoneNoCell, actionsCell);

  tbody.appendChild(tr);
};

const renderCarOwnerTableHeaders = (table) => {
  const tr = document.createElement("tr");
  const thead = document.createElement("thead");
  tr.appendChild(thead);
  const companyNameTh = renderTableHeader("Company name");
  const addressTh = renderTableHeader("Address");
  const phoneNoTh = renderTableHeader("Phone no");
  const actionsTh = renderTableHeader("Actions");

  thead.append(companyNameTh, addressTh, phoneNoTh, actionsTh);
  table.appendChild(thead);
};
