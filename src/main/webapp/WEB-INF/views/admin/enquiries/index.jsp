<%@include file="../../../shared/header.jsp" %>
<div class="jumbotron">
    <h1 class="display-4 text-center">ENQUIRIES</h1>
</div>

<button class="btn btn-info float-right mb-3 btn-sm" id="add-enquiry-btn"><i class="fa fa-plus"></i></button>
<div class="content-loader"></div>
<%@include file="enquiry-modal.jsp" %>
<%@include file="../followups/followup-modal.jsp" %>
<script>
    function loader() {
        var $content = $(".content-loader");
        $content.html("<div class='text-center'><div class='spinner-border'><span class='sr-only'>Loading...</span></div></div>");
        $.get('${SITE_URL}/admin/enquiries/table', (data) => {
            $content.html(data);
        });
    }
    
    function clear() {
        $('input').val('');
        $('select').prop("selectedIndex", 0);
    }
    
    $(document).ready(() => {
        loader();
        $.getJSON('${SITE_URL}/admin/enquiries/getJson', (data) => {
            var $status = $('#enquiry-status-id');
            var $source = $('#enquiry-source-id');
            $status.find('option').remove();
            $source.find('option').remove();
            $.each(data.statuses, (k, v) => {
                $status.append($('<option/>').val(v.id).text(v.name));
            });
            $.each(data.sources, (k, v) => {
                $source.append($('<option/>').val(v.id).text(v.name));
            });
        });

        $.getJSON('${SITE_URL}/admin/master/enquiries/followup/status/getJson', (data) => {
            var $status = $('#followup-status');
            $status.find('option').remove();
            $.each(data, (k, v) => {
                $status.append($('<option/>').val(v.id).text(v.name));
            });
        });

        $('#add-enquiry-btn').on('click', () => {
            let $dialog = $('#enquiry-modal');
            $dialog.find('.modal-title').html('Add Enquiry');
            $dialog.find('.btn-submit').html('Save');
            clear();
            $('#id').val(0);
            $dialog.modal();
        });

        $('#enquiry-form').on('submit', () => {
            $.ajax({
                url: '${SITE_URL}/admin/enquiries/',
                method: 'POST',
                data: $('#enquiry-form').serialize(),
                success: (resp) => {
                    $('#enquiry-modal').modal('hide');
                    loader();
                }
            });
            return false;
        });
        $('#followup-form').on('submit', () => {
            $enquiryid = $('#enquiryid').val();
            $.ajax({
                url: '${SITE_URL}/admin/enquiries/' + $enquiryid + '/followups',
                method: 'POST',
                data: $('#followup-form').serialize(),
                success: (resp) => {
                    let $dialog = $('#followup-modal');
                    $dialog.find('#followup-content').html("<div class='text-center'><div class='spinner-border'><span class='sr-only'>Loading...</span></div></div>");
                    $.get('${SITE_URL}/admin/enquiries/' + $enquiryid + '/followups/table', (data) => {
                        $dialog.find('#followup-content').html(data);
                    });
                    loader();
                    clear();
                }
            });
            return false;
        });
    });
</script>