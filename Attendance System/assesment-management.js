// Open edit modal and fill data
function editAssessment(button) {
    let row = button.closest("tr");
    let title = row.cells[0].innerText;
    let date = row.cells[1].innerText;

    document.getElementById("editTitle").value = title;
    document.getElementById("editDate").value = date;
    document.getElementById("editAssessmentForm").style.display = "block";

    // Save reference to row being edited
    document.getElementById("editAssessmentForm").dataset.row = row.rowIndex;
}

// Save changes
function saveAssessment() {
    let rowIndex = document.getElementById("editAssessmentForm").dataset.row;
    let table = document.getElementById("assessmentTable");

    let title = document.getElementById("editTitle").value;
    let date = document.getElementById("editDate").value;

    table.rows[rowIndex - 1].cells[0].innerText = title;
    table.rows[rowIndex - 1].cells[1].innerText = date;

    closeModal();
}

// Close edit modal
function closeModal() {
    document.getElementById("editAssessmentForm").style.display = "none";
}

// Delete assessment
function deleteAssessment(button) {
    let row = button.closest("tr");
    row.remove();
}
