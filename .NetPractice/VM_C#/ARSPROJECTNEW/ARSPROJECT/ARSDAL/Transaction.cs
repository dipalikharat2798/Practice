//------------------------------------------------------------------------------
// <auto-generated>
//     This code was generated from a template.
//
//     Manual changes to this file may cause unexpected behavior in your application.
//     Manual changes to this file will be overwritten if the code is regenerated.
// </auto-generated>
//------------------------------------------------------------------------------

namespace ARSDAL
{
    using System;
    using System.Collections.Generic;
    
    public partial class Transaction
    {
        public int TsID { get; set; }
        public Nullable<System.DateTime> BookingDate { get; set; }
        public Nullable<System.DateTime> DepartureDate { get; set; }
        public Nullable<int> Passenger { get; set; }
        public Nullable<int> Flight { get; set; }
        public Nullable<int> Charges { get; set; }
        public Nullable<int> Discount { get; set; }
    
        public virtual Charge Charge { get; set; }
        public virtual Discount Discount1 { get; set; }
        public virtual Flight_Schedule Flight_Schedule { get; set; }
        public virtual Passenger Passenger1 { get; set; }
    }
}