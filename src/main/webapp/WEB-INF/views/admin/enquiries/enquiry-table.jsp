<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="SITE_URL" value="${pageContext.request.contextPath}"/>
<table class="table table-hover">
    <thead>
        <tr>
            <th>Id</th>
            <th>Name</th>
            <th>Email</th>
            <th>Contact no</th>
            <th>Source</th>
            <th>Status</th>
            <th>Referred By</th>
            <th>Visited</th>
            <th>Followups</th>
            <th>Actions</th>
        </tr><!--tr-->
    </thead><!--thead-->
    <tbody>
        <c:forEach var="enquiry" items="${enquiries}"> 
            <tr>
                <td>${enquiry.id}</td>
                <td>${enquiry.firstName} ${enquiry.lastName}</td>
                <td>${enquiry.email}</td>
                <td>${enquiry.contactNo}</td>
                <td>${enquiry.enquirySource.name}</td>
                <td>${enquiry.enquiryStatus.name}</td>
                <td>${enquiry.referredBy}</td>
                <td>
                    <button class="btn btn-outline-primary visited-btn" data-id="${enquiry.id}">
                        <c:choose>
                            <c:when test="${enquiry.visited}">
                                Yes
                            </c:when>
                            <c:otherwise>
                                No
                            </c:otherwise>
                        </c:choose>
                    </button>
                </td>
                <td>
                    <button class="btn btn-primary btn-sm followup-btn" data-id="${enquiry.id}">
                        <i class="fa fa-plus"></i>
                        <span class="ml-2 badge badge-light">${enquiry.followUp}</span>
                    </button>
                </td>
                <td>
                    <button class="btn btn-primary btn-sm edit-enquiry-btn" data-id="${enquiry.id}"><i class="fa fa-edit"></i></button>
                    <button class="btn btn-danger btn-sm delete-enquiry-btn" data-toggle="modal" data-target="#confirm-modal" data-id="${enquiry.id}"><i class="fa fa-trash"></i></button>
                </td>
            </tr><!--tr-->
        </c:forEach>
    </tbody><!--tbody-->
</table<!--table-->

<script>
    $('.edit-enquiry-btn').on('click', function () {
        $('input').val('');
        $('select').prop("selectedIndex", 0);
        var $id = $(this).attr('data-id');
        let $dialog = $('#enquiry-modal');
        $dialog.find('.modal-title').html('Edit Enquiry');
        $dialog.find('.btn-submit').html('Update');
        $.get('${SITE_URL}/admin/enquiries/edit/' + $id, (data) => {
            $('#id').val(data.id);
            $('#firstname').val(data.firstName);
            $('#lastname').val(data.lastName);
            $('#email').val(data.email);
            $('#contactno').val(data.contactNo);
            $("#enquiry-source-id").val(data.enquirySource.id);
            $("#enquiry-status-id").val(data.enquiryStatus.id);
            $('#referredby').val(data.referredBy);
        });
        $dialog.modal();
    });

    $('.delete-enquiry-btn').on('click', function () {
        let $dialog = $('#confirm-modal');
        $('#delete-btn').attr('data-id', $(this).attr('data-id'));
        $dialog.modal();
    });

    $('#delete-btn').on('click', function () {
        var $id = $(this).attr('data-id');
        $.get('${SITE_URL}/admin/enquiries/delete/' + $id, () => {
            $('#confirm-modal').modal('hide');
            loader();
            toastr.info('Deleted Successfully');
        });
    });

    $('.visited-btn').on('click', function () {
        var $id = $(this).attr('data-id');
        $.get('${SITE_URL}/admin/enquiries/hasvisited/' + $id, () => {
            loader();
        });
    });

    $('.followup-btn').on('click', function () {
        var $id = $(this).attr('data-id');
        $('#enquiryid').val($id);
        let $dialog = $('#followup-modal');
        $dialog.find('#followup-content').html("<div class='text-center'><div class='spinner-border'><span class='sr-only'>Loading...</span></div></div>");
        $.get('${SITE_URL}/admin/enquiries/' + $id + '/followups/table', (data) => {
            $dialog.find('#followup-content').html(data);
            $dialog.modal();
        });
    });

    $('.followup-delete-btn').on('click', function () {
        var $id = $(this).attr('data-id');
        $.get('${SITE_URL}/admin/enquiries/delete/' + $id, () => {
            $('#confirm-modal').modal('hide');
            loader();
            toastr.info('Deleted Successfully');
        });
    });
</script>