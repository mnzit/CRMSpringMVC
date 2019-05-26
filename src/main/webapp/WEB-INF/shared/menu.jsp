<nav class="navbar navbar-expand-lg navbar-light bg-light mb-3">
    <a class="navbar-brand" href="${SITE_URL}">CRM</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNavDropdown" aria-controls="navbarNavDropdown" aria-expanded="false" aria-label="Toggle navigation">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="collapse navbar-collapse" id="navbarNavDropdown">
        <ul class="navbar-nav">
            <li class="nav-item active">
                <a class="nav-link" href="${SITE_URL}">Home</a>
            </li><!--li-->
            <li class="nav-item dropdown">
                <a class="nav-link dropdown-toggle" href="#" id="navbarDropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                    Enquiry
                </a>
                <div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
                    <a class="dropdown-item" href="${SITE_URL}/admin/enquiries">Enquiries</a>
                    <a class="dropdown-item" href="${SITE_URL}/admin/master/enquiries/followup/status">Followup status</a>
                    <a class="dropdown-item" href="${SITE_URL}/admin/master/enquiries/status">Enquiry status</a>
                    <a class="dropdown-item" href="${SITE_URL}/admin/master/enquiries/source">Enquiry source</a>
                </div>
            </li><!--li-->
        </ul><!--ul-->
    </div><!--collapse-->
</nav>